package com.example.demo;

import ControlFlow.*;
import ExpressionsStatementsAndMore.AreaCalculator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ExpressionsEndpoints {

    @GetMapping("/area-calc") // checked
    public ResponseEntity<String> calculateArea(
            @RequestParam(value = "number1") double number1,
            @RequestParam(value = "number2", required = false) double number2) {
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
