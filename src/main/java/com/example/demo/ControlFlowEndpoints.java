package com.example.demo;

import ControlFlow.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api")
public class ControlFlowEndpoints {

    @GetMapping("/diag-star/{number}") // checked // added
    public ResponseEntity<String> getStar(@PathVariable int number){
        try {
            return ResponseEntity
                    .status(200)
                    .body(DiagonalStar.printSquareStar(number));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/even-digit-sum/{number}") // checked // added
    public ResponseEntity<String> getEvenDigitSum(@PathVariable int number) {
        try{
            return ResponseEntity
                    .status(200)
                    .body(EvenDigitSum.getEvenDigitSum(number));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/factor-printer/{number}") // checked // added
    public ResponseEntity<String> getFactors(@PathVariable int number) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(FactorPrinter.printFactors(number));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/largest-prime/{number}") // checked // added
    public ResponseEntity<String> getLargestPrime(@PathVariable int number) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(LargestPrime.getLargestPrime(number));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/input-calculator") // not working
    public void getSumAndAverage() {
        InputCalculator.inputThenPrintSumAndAverage();
    }

    @GetMapping("/greatest-common-divisor") // checked // added
    public ResponseEntity<String> getGreatestCommonDivisor(
            @RequestParam(value = "number1") int number1,
            @RequestParam(value = "number2") int number2) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(GreatestCommonDivisor.getGreatestCommonDivisor(number1, number2));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/flour-packer") // checked // added
    public ResponseEntity<String> canPack(
            @RequestParam(value = "fiveKilo") int fiveKilo,
            @RequestParam(value = "oneKilo") int oneKilo,
            @RequestParam(value = "goal") int goal) {
        return ResponseEntity
                .status(200)
                .body(FlourPacker.canPack(fiveKilo, oneKilo, goal));
    }

    @GetMapping("/first-last-digit-sum/{number}") // checked // added
    public ResponseEntity<String> sumFirstAndLastDigit(@PathVariable int number) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(FirstLastDigitSum.sumFirstAndLastDigit(number));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/number-to-words/{number}") // checked // added
    public ResponseEntity<String> numberToWords(@PathVariable int number) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(NumberToWords.numberToWords(number));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/paint-job") // checked // added
    public ResponseEntity<String> getBucketCount(
            @RequestParam(value = "area", defaultValue = "-1") double area,
            @RequestParam(value = "width", defaultValue = "-1") double width,
            @RequestParam(value = "height", defaultValue = "-1") double height,
            @RequestParam(value = "areaPerBucket", defaultValue = "-1") double areaPerBucket,
            @RequestParam(value = "extraBuckets", defaultValue = "-1") int extraBuckets) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(Integer.toString(
                            area >= 0 ? PaintJob.getBucketCount(area,areaPerBucket) :
                            extraBuckets >= 0 ? PaintJob.getBucketCount(width, height, areaPerBucket, extraBuckets) :
                            PaintJob.getBucketCount(width, height, areaPerBucket)
                            )
                    );
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/perfect-number/{number}") // checked // added
    public ResponseEntity<String> isPerfectNumber(@PathVariable int number) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(PerfectNumber.isPerfectNumber(number));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/shared-digit") // checked // added
    public ResponseEntity<String> hasSharedDigit(
            @RequestParam(name = "number1") int number1,
            @RequestParam(name = "number2") int number2) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(SharedDigit.hasSharedDigit(number1,number2));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/sum-odd-range") // checked // added
    public ResponseEntity<String> sumOdd(
            @RequestParam(name = "start") int start,
            @RequestParam(name = "end") int end) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(SumOddRange.sumOdd(start, end));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/palindrome/{number}") // checked // added
    public ResponseEntity isPalindrome(@PathVariable int number) {
        return ResponseEntity
                .status(200)
                .body(NumberPalindrome.isPalindrome(number));
    }

    @GetMapping("/number-in-word/{number}") // checked // added
    public ResponseEntity inWord(@PathVariable int number) {
        return ResponseEntity
                .status(200)
                .body(NumberInWord.printNumberInWord(number));
    }

    @GetMapping("/days-in-month") // checked // added
    public ResponseEntity<String> getDaysInMonth(
            @RequestParam(name = "month") int month,
            @RequestParam(name = "year") int year) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(NumberOfDaysInMonth.getDaysInMonth(month, year));
        } catch (Exception e) {
            return ResponseEntity
                    .status(400)
                    .body(e.getMessage());
        }
    }
}
