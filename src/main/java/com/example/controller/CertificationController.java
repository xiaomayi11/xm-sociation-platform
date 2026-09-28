package com.example.controller;

import com.example.common.Result;
import com.example.entity.Certification;
import com.example.entity.CertificationApply;
import com.example.service.CertificationService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certification")
public class CertificationController {

    @Resource
    private CertificationService certificationService;

    @PostMapping("/add")
    public Result add(@RequestBody Certification certification) {
        certificationService.add(certification);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Certification certification) {
        certificationService.updateById(certification);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        certificationService.deleteById(id);
        return Result.success();
    }

    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        certificationService.deleteBatch(ids);
        return Result.success();
    }

    @GetMapping("/selectAll")
    public Result selectAll(Certification certification) {
        return Result.success(certificationService.selectAll(certification));
    }

    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             Certification certification) {
        PageInfo<Certification> pageInfo = certificationService.selectPage(pageNum, pageSize, certification);
        return Result.success(pageInfo);
    }

    @PostMapping("/apply/add")
    public Result applyAdd(@RequestBody CertificationApply certificationApply) {
        certificationService.addApply(certificationApply);
        return Result.success();
    }

    @PutMapping("/apply/update")
    public Result applyUpdate(@RequestBody CertificationApply certificationApply) {
        certificationService.updateApplyById(certificationApply);
        return Result.success();
    }

    @GetMapping("/apply/selectAll")
    public Result applySelectAll(CertificationApply certificationApply) {
        return Result.success(certificationService.selectApplyAll(certificationApply));
    }

    @GetMapping("/apply/selectPage")
    public Result applySelectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                  CertificationApply certificationApply) {
        PageInfo<CertificationApply> pageInfo = certificationService.selectApplyPage(pageNum, pageSize, certificationApply);
        return Result.success(pageInfo);
    }
}