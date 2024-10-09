package com.example.demo;

import ControlFlow.*;
import ExpressionsStatementsAndMore.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ExpressionsEndpoints {

    @GetMapping("/area-calc") // checked // added
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
    @GetMapping("/awake") // checked //added
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
    @GetMapping("/deci-comp") // checked // added
    public ResponseEntity<String> compareDecimals(
            @RequestParam(value = "number1") double number1,
            @RequestParam(value = "number2") double number2) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(Boolean.toString(DecimalComparator.areEqualByThreeDecimalPlaces(number1, number2)));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/equality-checker") // checked // added
    public ResponseEntity<String> checkEquation(
            @RequestParam(value = "number1") int number1,
            @RequestParam(value = "number2") int number2,
            @RequestParam(value = "number3") int number3) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(Boolean.toString(EqualSumChecker.hasEqualSum(number1, number2, number3)));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/equality-printer") // checked //added
    public ResponseEntity<String> printEqual(
            @RequestParam(value = "number1") int number1,
            @RequestParam(value = "number2") int number2,
            @RequestParam(value = "number3") int number3) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(IntEqualityPrinter.printEqual(number1, number2, number3));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/leap-year/{year}") // checked
    public ResponseEntity<String> isLeapYear(@PathVariable int year) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(Boolean.toString(LeapYear.isLeapYear(year)));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/mb-converter/{kiloBytes}") // checked
    public ResponseEntity<String> convertMegaBytes(@PathVariable int kiloBytes) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(MegaBytesConverter.printMegaBytesAndKiloBytes(kiloBytes));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }
    @GetMapping("/time-converter/{minutes}") // checked
    public ResponseEntity<String> convertMinutes(@PathVariable int minutes) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(MinutesToYearsDaysCalculator.printYearsAndDays(minutes));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }
    @GetMapping("/cat-playing") // checked
    public ResponseEntity<String> isCatPlaying(
            @RequestParam(value = "summer") boolean summer,
            @RequestParam(value = "temperature") int temperature) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(Boolean.toString(PlayingCat.isCatPlaying(summer,temperature)));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }
    @GetMapping("/check-number/{number}") // checked
    public ResponseEntity<String> checkNumber(@PathVariable int number) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(PositiveNegativeZero.checkNumber(number));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }
    @GetMapping("/speed-converter/{speed}") // checked
    public ResponseEntity<String> convertSpeed(@PathVariable double speed) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(SpeedConverter.printConversion(speed));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }
    @GetMapping("/has-teen") // checked
    public ResponseEntity<String> hasTeen(
            @RequestParam(value = "age1") int age1,
            @RequestParam(value = "age2") int age2,
            @RequestParam(value = "age3") int age3) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(Boolean.toString(TeenNumberChecker.hasTeen(age1, age2, age3)));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }
}
