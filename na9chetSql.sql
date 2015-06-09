SELECT * 
FROM client, materiel, fiche
LEFT JOIN attribution_devis_reparation ON attribution_devis_reparation.id_fiche = fiche.id_fiche LEFT JOIN 

devis_reparation on attribution_devis_reparation.id_devis_reparation= devis_reparation.id_devis_reparation

where fiche.id_client=client.id_client
and materiel.id_materiel= fiche.id_materiel