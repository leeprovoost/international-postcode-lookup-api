# DHL Routing Reference Data API (ESDv6)

This is a Java Dropwizard API wrapper around DHL's publicly available [Routing Reference Data](http://www.dhl.co.uk/en/express/resource_centre/integrated_shipping_solutions/developer_download_centre1.html#reference_data).

This is Alpha software quality and under heavy development.

## Get your REST service running

1. Make sure you have mongodb installed
2. Run the MongoDB database: `mongod`
3. Clone this git repository: `git clone git@github.com:leeprovoost/dhl-routing-reference-data-api.git`
4. Import the DHL data, follow instructions [here](https://github.com/leeprovoost/dhl-routing-reference-data-api/tree/master/routing_reference_data).
3. Go into the rest-service folder and build the service: `./build.sh`
4. Start the REST service: `./run.sh`

## Test your REST service

- View API listing: [http://localhost:3000/api-docs](http://localhost:3000/api-docs)
- View Swagger UI: [http://localhost:3000/swagger-ui/index.html](http://localhost:3000/swagger-ui/index.html)
- Get list of all countries: [http://localhost:3000/intl-routing-api/countries/](http://localhost:3000/intl-routing-api/countries/)
- Get list of cities (by default limited to 25): [http://localhost:3000/intl-routing-api/cities/](http://localhost:3000/intl-routing-api/cities/)
- View postcode lookup results: [http://localhost:3000/intl-routing-api/cities/?country=GB&postcode=SW8](http://localhost:3000/intl-routing-api/cities/?countryCode=GB&postcode=SW8)

## TODO

- Create test front-end
- Create conversion scripts for the DHL data files
- Use proper Data Transfer Objects instead of passing on the model object and hide ugliness of mongodb objects
- Implement Exception handling
- Add tests
- Implement all business rules described in DHL book (validate postcode patterns)
- Investigate MongoDB indexes or use of ElasticSearch
