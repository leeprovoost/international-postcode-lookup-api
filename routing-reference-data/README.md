# Import DHL Routing Reference Data (ESDv6) into MongoDB

I have converted the publicly accessible DHL [Routing Reference Data](http://www.dhl.co.uk/en/express/resource_centre/integrated_shipping_solutions/developer_download_centre1.html) into CSV files, stripped some of the unused columns and removed the header lines. 

I have uploaded zipped versions of the ESD v6 CSV files to my github repository, but make sure that you check the original files and the documentation that is provided on the [Developer Download Centre](http://www.dhl.co.uk/en/express/resource_centre/integrated_shipping_solutions/developer_download_centre1.html). The DHL documentation describes all the different fieldnames. I have replaced the field names in my imports with single letter field names to save space, however feel free to replace the field names in the import statements with your own.

Please do check with your contact person at DHL first to see whether you are allowed to use this data in your own application. The data (including the one in the converted CSV files) belong to DHL, not me. I'm just sharing my work whilst doing some import work on my own project. 

## How to install

1. Start your MongoDB service
```
mongod
```
2. Create a database named test (or use your own)
3. Create three collections named: routing_api_ESDv6, routing_api_country, routing_api_countryrpc (or use your own names)
4. Unzip the three zip files
5. Load the CSV files into MongoDB using following commands:
```
// ESD file
mongoimport --db test --collection routing_api_ESDv6 --type csv --fields a,b,c,d,e,f,g,h,i,j,k,l,m --file ./ESDv6.csv
// Country file
mongoimport --db test --collection routing_api_country --type csv --fields a,b,c,d --file ./country.csv 
// Country Postcode File
mongoimport --db test --collection routing_api_countrypc --type csv --fields a,b,c --file ./countrypc.csv 
```

## TODO

- Document match list of single letter labels to DHL labels
- Create conversion scripts to convert original DHL txt files to csv files for MongoDB import
- Create MongoDB initialisation script (create database, create tables, load data)
- Build REST API around this (Dropwizard, maybe Node.JS later)