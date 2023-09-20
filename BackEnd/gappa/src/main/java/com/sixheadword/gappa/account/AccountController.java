package com.sixheadword.gappa.account;

import com.sixheadword.gappa.account.dto.request.SetPrimaryReqeustDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
@Slf4j
public class AccountController {

    private final AccountService accountService;

    @PutMapping("/test")
    public ResponseEntity<?> test(){
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // API 1. 대표 계좌 설정
    @PostMapping("/primary")
    public ResponseEntity<?> setPrimaryAccount(@RequestBody SetPrimaryReqeustDto setPrimaryReqeustDto){
        try{
            accountService.setPrimaryAccount(setPrimaryReqeustDto);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("대표 계좌 설정 실패");
        }
    }

    // API 2. 대표 계좌 변경
    @PutMapping("/primary")
    public ResponseEntity<?> changePrimaryAccount(@RequestBody SetPrimaryReqeustDto setPrimaryReqeustDto){
        try{
            accountService.changePrimaryAccount(setPrimaryReqeustDto);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("전체 계좌 조회 실패");
        }
    }

    // API 3. 대표 계좌 조회
    @GetMapping("/primary/{userSeq}")
    public ResponseEntity<?> showPrimaryAccount(@PathVariable("userSeq") Long userSeq) {
        try{
            return ResponseEntity.ok(accountService.getPrimaryAccount(userSeq));
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("전체 계좌 조회 실패");
        }
    }

    // API 4. 전체 계좌 조회
//    @GetMapping("/{userSeq}")
//    public ResponseEntity<?> showAllAccount(){
//        try{
//            return ResponseEntity.ok(accountService.getAllAcount(userSeq));
//        }catch (IllegalArgumentException e){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("전체 계좌 조회 실패");
//        }
//    }

}
