package com.gavin.test.playwright;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.List;

public class PageInfo {

    private Integer total;
    private List<ListDTO> list;
    private Integer pageNum;
    private Integer pageSize;
    private Integer size;
    private Integer startRow;
    private Integer endRow;
    private Integer pages;
    private Integer prePage;
    private Integer nextPage;
    private Boolean isFirstPage;
    private Boolean isLastPage;
    private Boolean hasPreviousPage;
    private Boolean hasNextPage;
    private Integer navigatePages;
    private List<Integer> navigatepageNums;
    private Integer navigateFirstPage;
    private Integer navigateLastPage;

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<ListDTO> getList() {
        return this.list;
    }

    public void setList(List<ListDTO> list) {
        this.list = list;
    }

    public Integer getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStartRow() {
        return this.startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getEndRow() {
        return this.endRow;
    }

    public void setEndRow(Integer endRow) {
        this.endRow = endRow;
    }

    public Integer getPages() {
        return this.pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPrePage() {
        return this.prePage;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public Integer getNextPage() {
        return this.nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Boolean getFirstPage() {
        return this.isFirstPage;
    }

    public void setFirstPage(Boolean firstPage) {
        this.isFirstPage = firstPage;
    }

    public Boolean getLastPage() {
        return this.isLastPage;
    }

    public void setLastPage(Boolean lastPage) {
        this.isLastPage = lastPage;
    }

    public Boolean getHasPreviousPage() {
        return this.hasPreviousPage;
    }

    public void setHasPreviousPage(Boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public Boolean getHasNextPage() {
        return this.hasNextPage;
    }

    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public Integer getNavigatePages() {
        return this.navigatePages;
    }

    public void setNavigatePages(Integer navigatePages) {
        this.navigatePages = navigatePages;
    }

    public List<Integer> getNavigatepageNums() {
        return this.navigatepageNums;
    }

    public void setNavigatepageNums(List<Integer> navigatepageNums) {
        this.navigatepageNums = navigatepageNums;
    }

    public Integer getNavigateFirstPage() {
        return this.navigateFirstPage;
    }

    public void setNavigateFirstPage(Integer navigateFirstPage) {
        this.navigateFirstPage = navigateFirstPage;
    }

    public Integer getNavigateLastPage() {
        return this.navigateLastPage;
    }

    public void setNavigateLastPage(Integer navigateLastPage) {
        this.navigateLastPage = navigateLastPage;
    }

    public static class ListDTO {
        @ExcelProperty("代理记账证书号")
        private String dlzjNo;
        @ExcelProperty("机构联系方式")
        private String dljzPhone;
        @ExcelProperty("业务负责人")
        private String dljzBusLeader;
        @ExcelProperty("机构名称")
        private String dlzjName;
        @ExcelProperty("所在地区")
        private String dljzLocation;
        @ExcelProperty("机构类型")
        private String dljzOrgtype;
        @ExcelProperty("组织形式")
        private String dljzOrgform;
        @ExcelProperty("邮箱")
        private String dljzEmail;
        @ExcelProperty("状态")
        private String dljzStatus;
        @ExcelProperty("注册资本（万元）")
        private String dljzTotalinves;
        @ExcelProperty("办公地址")
        private String dljzAddr;
        @ExcelProperty("机构负责人")
        private String dljzLeader;
        @ExcelProperty("发证日期")
        private String dljzCertdate;

        public String getDlzjNo() {
            return this.dlzjNo;
        }

        public void setDlzjNo(String dlzjNo) {
            this.dlzjNo = dlzjNo;
        }

        public String getDljzPhone() {
            return this.dljzPhone;
        }

        public void setDljzPhone(String dljzPhone) {
            this.dljzPhone = dljzPhone;
        }

        public String getDljzBusLeader() {
            return this.dljzBusLeader;
        }

        public void setDljzBusLeader(String dljzBusLeader) {
            this.dljzBusLeader = dljzBusLeader;
        }

        public String getDlzjName() {
            return this.dlzjName;
        }

        public void setDlzjName(String dlzjName) {
            this.dlzjName = dlzjName;
        }

        public String getDljzLocation() {
            return this.dljzLocation;
        }

        public void setDljzLocation(String dljzLocation) {
            this.dljzLocation = dljzLocation;
        }

        public String getDljzOrgtype() {
            return this.dljzOrgtype;
        }

        public void setDljzOrgtype(String dljzOrgtype) {
            this.dljzOrgtype = dljzOrgtype;
        }

        public String getDljzOrgform() {
            return this.dljzOrgform;
        }

        public void setDljzOrgform(String dljzOrgform) {
            this.dljzOrgform = dljzOrgform;
        }

        public String getDljzEmail() {
            return this.dljzEmail;
        }

        public void setDljzEmail(String dljzEmail) {
            this.dljzEmail = dljzEmail;
        }

        public String getDljzStatus() {
            return this.dljzStatus;
        }

        public void setDljzStatus(String dljzStatus) {
            this.dljzStatus = dljzStatus;
        }

        public String getDljzTotalinves() {
            return this.dljzTotalinves;
        }

        public void setDljzTotalinves(String dljzTotalinves) {
            this.dljzTotalinves = dljzTotalinves;
        }

        public String getDljzAddr() {
            return this.dljzAddr;
        }

        public void setDljzAddr(String dljzAddr) {
            this.dljzAddr = dljzAddr;
        }

        public String getDljzLeader() {
            return this.dljzLeader;
        }

        public void setDljzLeader(String dljzLeader) {
            this.dljzLeader = dljzLeader;
        }

        public String getDljzCertdate() {
            return this.dljzCertdate;
        }

        public void setDljzCertdate(String dljzCertdate) {
            this.dljzCertdate = dljzCertdate;
        }
    }
}
