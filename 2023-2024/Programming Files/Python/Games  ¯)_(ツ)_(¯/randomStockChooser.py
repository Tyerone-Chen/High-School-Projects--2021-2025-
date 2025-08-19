# -*- coding: utf-8 -*-
"""
Created on Mon Mar 25 13:28:20 2024

@author: Tyerone Chen
"""

from random import randint

companyList = ["NVIDIA", "Tesla", "Alphabet Inc", "Amazon", "Microsoft", 
               "Palantir Tech", "Intel", "Phunware Corp", "Walt Disney",
               "Mobil", "Digital World Acquisit", "Taiwan Semiconductor",
               "Paypal", "ALibaba", "Lucid", "Netflix", "Dell", "Qualcomm", 
               "Costco", "Broadcom", "Lam Research Corp", "Block Inc", 
               "Upstart", "Blackstone Inc", "Capital One", "American Express",
               "Walmart", "Coca-Cola", "Carvana", "Starbucks", "Celsius",
               "Target", "Texas Instruments", "Pfizer", "Eli Lily & Co",
               "Viking Therapeutics", "Bristol-Myers", "Merck & Co", 
               "Pepsi", "Standex International", "AeroVironment",
               "L3Harris Tech", "3M Co", "American Airlines", "Take-Two Interactive", 
               "Charter Communications"];
stockAmountList = [50, 50, 50, 50, 50, 50, 75, 75, 75, 75, 100, 100, 100, 100,
                   150, 150, 150, 150, 150, 200, 200, 200, 300, 300, 350, 350, 
                   350, 350, 400, 400, 400, 450, 450, 500, 500, 1000];

def investStock():
    randCompany = companyList[randint(0, len(companyList) - 1)]
    randStockAmount = stockAmountList[randint(0, len(stockAmountList) - 1)]
    
    print(f"You Should Invest in {randCompany} with {randStockAmount} Stocks")
    
investStock()