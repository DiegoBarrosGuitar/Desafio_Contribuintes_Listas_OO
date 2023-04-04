package entities;

public class TaxPayer {

    private Double salaryIncome; //Renda salarial;
    private Double servicesSincome; //prestação de serviços;
    private Double capitalIncome; //Renda de Capital;
    private Double healthSpending;  //Despesas com saúde;
    private Double educationSpending; //Despesas com educação;
    
    
    public TaxPayer() {    
    }
    
    public TaxPayer(Double salaryIncome, Double servicesSincome, Double capitalIncome, Double healthSpending,
            Double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesSincome = servicesSincome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public Double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(Double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public Double getServicesSincome() {
        return servicesSincome;
    }

    public void setServicesSincome(Double servicesSincome) {
        this.servicesSincome = servicesSincome;
    }

    public Double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(Double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public Double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(Double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public Double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(Double educationSpending) {
        this.educationSpending = educationSpending;
    }
    
    public double salaryTax(Double salaryAnnual) {
        double taxSalary;
        if (salaryAnnual < 36000) {
            taxSalary = 0;
        }
        else if (salaryAnnual < 60000) {
            taxSalary = salaryAnnual * 0.1;
        }
        else {
            taxSalary = salaryAnnual * 0.2;
        }
        return taxSalary;
    }
     
    //imposto sobre serviços
    public double servicesTax (Double serviceAnnual) {  
        double taxServices;
        if (serviceAnnual < 36000) {
            taxServices = 0;
        }
        else {
            taxServices = serviceAnnual * 0.15;
        }
        return taxServices;
    }
     
    //imposto sobre ganho de capital
    public double capitalTax(Double gainCapital) {
        double taxCapitalGain;
        if (gainCapital > 0) {
            taxCapitalGain = gainCapital * 0.2;
        }
        else {
            taxCapitalGain = 0;
        }
        return taxCapitalGain;
    }
     
    //imposto bruto
    public double grossTax(Double taxSalary, Double taxServices, Double taxCapitalGain) {
        double taxGross = taxSalary + taxServices + taxCapitalGain;
        return taxGross;
    }
     
 // Deduções
    public double taxRebate(Double maximumDeductible, Double taxGross, Double deductibleExpenses, Double expensesMedical, Double expensesEducation, Double rebate) {
        maximumDeductible = taxGross * 0.3;

        deductibleExpenses = expensesMedical + expensesEducation;

        if (maximumDeductible < deductibleExpenses) {
            rebate = maximumDeductible;
        } else {
            rebate = deductibleExpenses;
        }

        return rebate;
    }
}
