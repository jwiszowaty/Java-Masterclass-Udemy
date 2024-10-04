package com.example.demo;

import ControlFlow.*;
import ExpressionsStatementsAndMore.AreaCalculator;
import ExpressionsStatementsAndMore.BarkingDog;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ExpressionsEndpoints {

    @GetMapping("/area-calc") // checked
    public ResponseEntity<String> calculateArea(
            @RequestParam(value = "number1") double number1,
            @RequestParam(value = "number2") double number2) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(Double.toString(number2 > 0 ? AreaCalculator.area(number1,number2) :AreaCalculator.area(number1) ));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }
    @GetMapping("/awake") // checked
    public ResponseEntity<String> calculateArea(
            @RequestParam(value = "isBarking") boolean isBarking,
            @RequestParam(value = "time") int time) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(Boolean.toString(BarkingDog.shouldWakeUp(isBarking, time)));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }

//    @GetMapping("/") // checked // added
//    public ResponseEntity<String> sumFirstAndLastDigit(@PathVariable int number) {
//        try {
//            return ResponseEntity
//                    .status(200)
//                    .body(FirstLastDigitSum.sumFirstAndLastDigit(number));
//        } catch (Exception e) {
//            return ResponseEntity
//                    .status(400)
//                    .body(e.getMessage());
//        }
//    }
}
