package com.webservice1.repositories;

import com.webservice1.models.Chambre;
import com.webservice1.models.ComparateurOffre;
import com.webservice1.models.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ComparateurOffreRepository extends JpaRepository<ComparateurOffre, Long> {

    // Le Comparateur
    @Query(value = "SELECT DISTINCT C.ID_CHAMBRE AS idChambre, H.*, C.*, A.*, " +
            "CASE WHEN HA.ID IS NOT NULL THEN C.PRIX_NUIT * (1 - COALESCE(HA.POURCENTAGE / 100, 0)) ELSE C.PRIX_NUIT END AS prixAvecReduction, " +
            "HA.ID_AGENCE AS idAgenceResponsable, " +
            "AG.NOM_AGENCE AS nomAgence, " +
            "CASE WHEN EXISTS (\n" +
            "    SELECT 1\n" +
            "    FROM Reservation R\n" +
            "    WHERE C.ID_CHAMBRE = R.ID_CHAMBRE\n" +
            "    AND NOT (R.DATE_ARRIVEE > :dateSortie OR R.DATE_DE_DEPART < :dateEntree)\n" +
            ") THEN 'indisponible' ELSE 'disponible' END AS DISPONIBILITE_STATUS" +
            "FROM Hotel H " +
            "JOIN Chambre C ON H.ID_HOTEL = C.ID_HOTEL " +
            "JOIN Adresse A ON H.ID_ADRESSE = A.ID_ADRESSE " +
            "LEFT JOIN Partenariat HA ON H.ID_HOTEL = HA.ID_HOTEL " +
            "LEFT JOIN Agence AG ON HA.ID_AGENCE = AG.ID_AGENCE " +
            "WHERE A.VILLE_HOTEL = :ville " +
            "AND H.NBR_ETOILE = :nombreEtoile " +
            "AND C.NBR_LIT = :nombreLit " +
            "AND C.PRIX_NUIT BETWEEN :prixMin AND :prixMax", nativeQuery = true)
    List<ComparateurOffre> comparateur(@Param("ville") String ville, @Param("dateEntree") String dateEntree, @Param("dateSortie") String dateSortie, @Param("nombreEtoile") int nombreEtoile, @Param("nombreLit") int nombreLit, @Param("prixMin") double prixMin, @Param("prixMax") double prixMax);

    @Query(value = "SELECT " +
            "h.ID_HOTEL, " +
            "h.NOM, " +
            "h.NBR_ETOILE, " +
            "a.VILLE_HOTEL, " +
            "a.RUE_HOTEL, " +
            "a.NUMERO, " +
            "a.LIEU_DIT, " +
            "a.POSITIONGPS, " +
            "c.ID_CHAMBRE, " +
            "c.TYPE_CHAMBRE, " +
            "c.NBR_LIT, " +
            "CASE " +
            "   WHEN p.ID IS NOT NULL THEN (c.PRIX_NUIT - (c.PRIX_NUIT * p.POURCENTAGE / 100)) " +
            "   ELSE c.PRIX_NUIT " +
            "END AS PRIX_NUIT, " +
            "c.IMAGE_CHAMBRE, " +
            "CASE " +
            "   WHEN EXISTS (" +
            "       SELECT 1 " +
            "       FROM Reservation R " +
            "       WHERE c.ID_CHAMBRE = R.ID_CHAMBRE " +
            "       AND NOT (R.DATE_ARRIVEE > :dateArrivee OR R.DATE_DE_DEPART < :dateDeDepart)" +
            "   ) THEN 'Occupée' " +
            "   ELSE c.DISPONIBILITE " +
            "END AS DISPONIBILITE " +
            "FROM " +
            "   HOTEL h " +
            "JOIN " +
            "   CHAMBRE c ON h.ID_HOTEL = c.ID_HOTEL " +
            "JOIN " +
            "   ADRESSE a ON h.ID_ADRESSE = a.ID_ADRESSE " +
            "LEFT JOIN " +
            "   Partenariat p ON h.ID_HOTEL = p.ID_HOTEL AND p.ID_AGENCE = :idAgence " +
            "WHERE " +
            "   a.VILLE_HOTEL = :ville " +
            "   AND h.NBR_ETOILE = :nbrEtoile " +
            "   AND c.PRIX_NUIT BETWEEN :prixMin AND :prixMax " +
            "   AND c.NBR_LIT = :nbrPersonnes", nativeQuery = true)
    List<ComparateurOffre> afficherOffre(@Param("ville") String ville, @Param("dateArrivee") String dateArrivee, @Param("dateDeDepart") String dateDeDepart, @Param("prixMin") double prixMin, @Param("prixMax") double prixMax, @Param("nbrEtoile") int nbrEtoile, @Param("nbrPersonnes") int nbrPersonnes, @Param("idAgence") long idAgence);



}
