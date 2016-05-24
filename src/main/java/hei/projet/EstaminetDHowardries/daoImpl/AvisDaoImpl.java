package hei.projet.EstaminetDHowardries.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.EstaminetDHowardries.entite.Avis;

public class AvisDaoImpl {

	public void ajouterAvis(Avis avis) {

		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection
					.prepareStatement("INSERT INTO `avis`(`commentaire`, `note`) VALUES (?,?)");
			stmt.setString(1, avis.getCommentaire());
			stmt.setInt(2, avis.getNote());

			stmt.executeUpdate();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Avis> listerAvis() {
		List<Avis> listeAvis = new ArrayList<Avis>();

		try {
			Connection connection = (Connection) DataSourceProvider.getDataSource().getConnection();
			Statement stmt = (Statement) connection.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM avis");

			while (results.next()) {
				Avis avis = new Avis();

				avis.setIdAvis(results.getInt("idAvis"));
				avis.setCommentaire(results.getString("commentaire"));
				avis.setNote(results.getInt("note"));

				listeAvis.add(avis);

			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeAvis;
	}
}
