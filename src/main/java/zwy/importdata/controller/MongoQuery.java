//package zwy.importdata.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import zwy.importdata.mongo.MongoRepo;
//
//import java.util.List;
//
//@RestController
//public class MongoQuery {
//
//    @Autowired
//    private MongoRepo mongoRepo;
//
//    @GetMapping("/mongo")
//    public ResponseEntity testMongo(String type, String collection, int page, int size) {
//        List<String> byType = mongoRepo.findByType(type, collection, page, size);
//        return ResponseEntity.ok(byType);
//    }
//}
