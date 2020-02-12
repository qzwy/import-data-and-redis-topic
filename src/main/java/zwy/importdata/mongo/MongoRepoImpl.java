//package zwy.importdata.mongo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.mongodb.core.MongoOperations;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class MongoRepoImpl implements MongoRepo{
//
//    @Autowired
//    private MongoOperations mongoOperations;
//
//
//    @Override
//    public List<String> findByType(String type, String collection, int page, int size) {
//        Query query =new Query(Criteria.where("type").is(type)).with(PageRequest.of(page,size));
//        return mongoOperations.find(query, String.class, collection);
//    }
//
//    @Override
//    public void addDataQuery(String DataQuery) {
//
//    }
//
//}
