package com.example.demo;

import ExpressionsStatementsAndMore.*;
import Inheritance.*;
import Inheritance.CarpetCostCalculator.Calculator;
import Inheritance.CarpetCostCalculator.Carpet;
import Inheritance.CarpetCostCalculator.Floor;
import Inheritance.PoolArea.Cuboid;
import Inheritance.PoolArea.Rectangle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class InheritanceEndpoints {

    @GetMapping("/simple-calculator") // checked
    public ResponseEntity<String> simpleCalculation(
            @RequestParam(value = "number1") double number1,
            @RequestParam(value = "number2") double number2,
            @RequestParam(value = "method") String method) {
        try {
            SimpleCalculator calculator = new SimpleCalculator();
            calculator.setFirstNumber(number1);
            calculator.setSecondNumber(number2);
            double result = 0;
            switch (method) {
                case "add" -> result = calculator.getAdditionResult();
                case "sub" -> result = calculator.getSubtractionResult();
                case "multi" -> result = calculator.getMultiplicationResult();
                case "div" -> result = calculator.getDivisionResult();
                default -> result = 12345.6789;
            }
            return ResponseEntity
                    .status(200)
                    .body(Double.toString(result));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/complex-numbers") // checked
    public ResponseEntity<String> simpleCalculation(
            @RequestParam(value = "real1") double real1,
            @RequestParam(value = "imaginary1") double imaginary1,
            @RequestParam(value = "real2") double real2,
            @RequestParam(value = "imaginary2") double imaginary2,
            @RequestParam(value = "method") String method) {
        try {
            ComplexNumber complexNumber1 = new ComplexNumber(real1,imaginary1);
            ComplexNumber complexNumber2 = new ComplexNumber(real2,imaginary2);
            switch (method) {
                case "add" -> complexNumber1.add(complexNumber2);
                case "sub" -> complexNumber1.subtract(complexNumber2);
            }
            return ResponseEntity
                    .status(200)
                    .body(complexNumber1.getReal() + " + " + complexNumber1.getImaginary() + "i");
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }
    @GetMapping("/person") // checked
    public ResponseEntity<String> createPerson(
            @RequestParam(value = "first") String first,
            @RequestParam(value = "last") String last,
            @RequestParam(value = "age") int age) {
        try {
            Person person = new Person();
            person.setFirstName(first);
            person.setLastName(last);
            person.setAge(age);
            return ResponseEntity
                    .status(200)
                    .body(person.getFullName() + " is" + (person.isTeen() ? "" : " not") + " a teenager.");
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }
    @GetMapping("/point") // checked
    public ResponseEntity<String> findDistance(
            @RequestParam(value = "x1") int x1,
            @RequestParam(value = "y1") int y1,
            @RequestParam(value = "x2") int x2,
            @RequestParam(value = "y2") int y2) {
        try {
            Point point1 = new Point(x1,y1);
            Point point2 = new Point(x2,y2);
            double distance = point1.distance(point2);
            return ResponseEntity
                    .status(200)
                    .body(Double.toString(distance));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }
    @GetMapping("/wall") // checked
    public ResponseEntity<String> createWall(
            @RequestParam(value = "width") double width,
            @RequestParam(value = "height") double height) {
        try {
            Wall wall = new Wall(width, height);
            return ResponseEntity
                    .status(200)
                    .body(Double.toString(wall.getArea()));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }
    @GetMapping("/cuboid") // checked
    public ResponseEntity<String> createCuboid(
            @RequestParam(value = "width") double width,
            @RequestParam(value = "length") double length,
            @RequestParam(value = "height") double height) {
        try {
            Cuboid cuboid = new Cuboid(width, length, height);
            return ResponseEntity
                    .status(200)
                    .body(Double.toString(cuboid.getVolume()));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }
    @GetMapping("/carpet") // check
    public ResponseEntity<String> calculateCarpetCost(
            @RequestParam(value = "width") double width,
            @RequestParam(value = "length") double length,
            @RequestParam(value = "cost") double cost) {
        try {
            Floor floor = new Floor(width, length);
            Carpet carpet = new Carpet(cost);
            Calculator calculator = new Calculator(floor, carpet);
            return ResponseEntity
                    .status(200)
                    .body(Double.toString(calculator.getTotalCost()));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }
}
