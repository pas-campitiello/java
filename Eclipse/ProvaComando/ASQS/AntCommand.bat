@echo off
    cd C:\Programmi\Apache~1\synapse-1.2\samples\axis2Client
    ant stockquote -Dtrpurl=http://localhost:8280/soap/StockQuoteProxy -Dmode=quote -Dsymbol=IBM