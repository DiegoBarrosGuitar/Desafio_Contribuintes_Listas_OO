package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class ProgramContribuintes {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Quantos contribuintes você vai digitar? ");
        int n = sc.nextInt();
        System.out.println();

        for (int i = 1; i <= n; i++) {
            System.out.println("Digite os dados do " + i + "o contribuinte:");
            System.out.print("Renda anual com salário: ");
            Double salaryIncome = sc.nextDouble();
            System.out.print("Renda anual com prestação de serviço: ");
            Double servicesIncome = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            Double capitalIncome = sc.nextDouble();
            System.out.print("Gastos médicos: ");
            Double healthSpending = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            Double educationSpending = sc.nextDouble();
            System.out.println();

            taxPayers.add(new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending));
        }

        System.out.println();
        System.out.println("RELATÓRIO DE IMPOSTO:");
        System.out.println();

        for (int i = 0; i < taxPayers.size(); i++) {
            TaxPayer taxPayer = taxPayers.get(i);

            double salaryTax = taxPayer.salaryTax(taxPayer.getSalaryIncome());
            double servicesTax = taxPayer.servicesTax(taxPayer.getServicesSincome());
            double capitalTax = taxPayer.capitalTax(taxPayer.getCapitalIncome());
            double grossTax = taxPayer.grossTax(salaryTax, servicesTax, capitalTax);

            double deductibleExpenses = taxPayer.getEducationSpending() + taxPayer.getHealthSpending();
            double maximumDeductible = grossTax * 0.3;
            double rebate = taxPayer.taxRebate(maximumDeductible, grossTax, deductibleExpenses, taxPayer.getHealthSpending(), taxPayer.getEducationSpending(), (double) 0);

            double taxDue = grossTax - rebate;

            System.out.println("Resumo do " + (i+1) + "o contribuinte:");
            System.out.println("Imposto bruto total: $" + String.format("%.2f", grossTax));
            System.out.println("Abatimento: $" + String.format("%.2f", rebate));
            System.out.println("Imposto devido: $" + String.format("%.2f", taxDue));
            System.out.println();
        }

        sc.close();
    }
}

