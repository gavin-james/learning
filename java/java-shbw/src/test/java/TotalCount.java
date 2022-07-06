import org.junit.platform.commons.util.StringUtils;

import java.util.List;


public class TotalCount {


  private String taxpayercode;
  private String invalidstatus;
  private String periodname;
  private Integer invoicerow;
  private String invoicetype;
  private List<DetailDTO> detail;
  private String invoicedate;
  private String invoicedescription;

  public Integer getInvoicerow() {
    return detail.size();
  }

  public String getTaxpayercode() {
    return taxpayercode;
  }

  public void setTaxpayercode(String taxpayercode) {
    this.taxpayercode = taxpayercode;
  }

  public String getInvalidstatus() {
    return invalidstatus;
  }

  public void setInvalidstatus(String invalidstatus) {
    this.invalidstatus = invalidstatus;
  }

  public String getPeriodname() {
    return periodname;
  }

  public void setPeriodname(String periodname) {
    this.periodname = periodname;
  }

  public void setInvoicerow(Integer invoicerow) {
    this.invoicerow = invoicerow;
  }

  public String getInvoicetype() {
    return invoicetype;
  }

  public void setInvoicetype(String invoicetype) {
    this.invoicetype = invoicetype;
  }

  public List<DetailDTO> getDetail() {
    return detail;
  }

  public void setDetail(List<DetailDTO> detail) {
    this.detail = detail;
  }

  public String getInvoicedate() {
    return invoicedate;
  }

  public void setInvoicedate(String invoicedate) {
    this.invoicedate = invoicedate;
  }

  public String getInvoicedescription() {
    return invoicedescription;
  }

  public void setInvoicedescription(String invoicedescription) {
    this.invoicedescription = invoicedescription;
  }

  public static class DetailDTO {
    private String taxTypeName;
    private String totalAmount;
    private String taxPate;
    private String taxTypeCode;
    private String invoiceattribute;
    private String noTaxAmount;
    private String taxAmount;

    public String getInvoiceAttribute() {
      if (!StringUtils.isBlank(invoiceattribute) && invoiceattribute.equals("不征税")) {
        return "NT";
      }
      if (!StringUtils.isBlank(invoiceattribute) && invoiceattribute.equals("免税")) {
        return "TF";
      }
      return "";
    }

    public String getTaxTypeName() {
      return taxTypeName;
    }

    public void setTaxTypeName(String taxTypeName) {
      this.taxTypeName = taxTypeName;
    }

    public String getTotalAmount() {
      return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
      this.totalAmount = totalAmount;
    }

    public String getTaxPate() {
      return taxPate;
    }

    public void setTaxPate(String taxPate) {
      this.taxPate = taxPate;
    }

    public String getTaxTypeCode() {
      return taxTypeCode;
    }

    public void setTaxTypeCode(String taxTypeCode) {
      this.taxTypeCode = taxTypeCode;
    }

    public String getInvoiceattribute() {
      return invoiceattribute;
    }

    public void setInvoiceattribute(String invoiceattribute) {
      this.invoiceattribute = invoiceattribute;
    }

    public String getNoTaxAmount() {
      return noTaxAmount;
    }

    public void setNoTaxAmount(String noTaxAmount) {
      this.noTaxAmount = noTaxAmount;
    }

    public String getTaxAmount() {
      return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
      this.taxAmount = taxAmount;
    }
  }
}
