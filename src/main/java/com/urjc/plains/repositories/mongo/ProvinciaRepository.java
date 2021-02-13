package com.urjc.plains.repositories.mongo;

import com.urjc.plains.dtos.mongo.ProvinciaPorComunidad;
import com.urjc.plains.models.mongo.Provincia;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProvinciaRepository extends MongoRepository<Provincia, String> {

    @Aggregation(pipeline = { "{ $project: { \"Comunidad\": { $ifNull: [\"$CA\", \"Sin comunidad\"] },\"_id\":0 } }",
            "{ $group: { _id: \"$Comunidad\", \"numeroProvincias\": { $sum: 1 } } }" })
    List<ProvinciaPorComunidad> findProvinciasPorComunidad();
}
