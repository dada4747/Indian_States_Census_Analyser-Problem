package com.bridgelabz;

import com.opencsv.bean.CsvBindByName;

public class IndiaStateCodeCSV {
    @CsvBindByName(column = "SrNo")
    private String srNo;

    @CsvBindByName(column = "State Name")
    private String state;

    @CsvBindByName(column = "TIN")
    private String tin;

    @CsvBindByName(column = "StateCode", required = true)
    private String stateCode;


    @Override
    public String toString() {
        return "srNo = " + srNo +
                ", state = " + state +
                ", tin = " + tin +
                ", stateCode = " + stateCode;
    }
}