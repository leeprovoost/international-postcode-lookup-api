# DHL Routing Reference Data API (ESDv6)

This is a Java Dropwizard API wrapper around DHL's publicly available [Routing Reference Data](http://www.dhl.co.uk/en/express/resource_centre/integrated_shipping_solutions/developer_download_centre1.html#reference_data).

This is Alpha software quality and under heavy development.

## Includes 
- Dropwizard 0.6.2
- Swagger 1.2

## Setup

1. Install MongoDB: todo
2. Clone repository: git clone git@github.com:leeprovoost/dhl-routing-reference-data-api.git
3. Build using Maven: mvn package

## Set up your MongoDB database

See [here](https://github.com/leeprovoost/dhl-routing-reference-data-api/tree/master/routing_reference_data).

## Start your application

- Start MongoDB: mongod
- Start REST service: java -jar target/intl-routing-api-0.0.1-SNAPSHOT.jar server configuration.yml

## Test your application

- View API listing: http://localhost:3000/api-docs
- View Swagger UI: http://localhost:3000/swagger-ui/index.html
- View postcode lookup results: http://localhost:3000/intl-routing-api/countries/?countryCode=GB&postcode=SW8
- Get list of countries: http://localhost:3000/intl-routing-api/countries/

## TODO

- Create test front-end
- Create conversion scripts for the DHL data files
- Use proper Data Transfer Objects instead of passing on the model object and hide ugliness of mongodb objects
- Implement Exception handling
- Add tests
- Implement all business rules described in DHL book (validate postcode patterns)
- Investigate MongoDB indexes or use of ElasticSearch
