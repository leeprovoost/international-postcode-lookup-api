# International Postcode Lookup API

This is a Java Dropwizard API wrapper around DHL's publicly available [Routing Reference Data](http://www.dhl.co.uk/en/express/resource_centre/integrated_shipping_solutions/developer_download_centre1.html#reference_data). It uses a subset of the data to allow international postcode lookups. This is useful for companies that have DHL as a delivery partner and want to ensure that the postcode and city combination match the ones that DHL use.

This supports ESDv6 (latest version on 21 April 2014). 

Please note that:
- this is Alpha software quality and under heavy development; and
- this is not affiliated with or endorsed by DHL; and
- this project only gives you data conversion tools and a REST wrapper around DHL's data set. You still need to agree with DHL whether you can use the data set for your intendend purposes.

## Get your REST service running

1. Make sure you have mongodb installed
2. Run the MongoDB database: `mongod`
3. Clone this git repository: `git clone git@github.com:leeprovoost/international-postcode-lookup-api.git`
4. Import the DHL data, follow instructions [here](https://github.com/leeprovoost/dhl-routing-reference-data-to-mongodb).
3. Go into the rest-service folder and build the service: `./build.sh`
4. Start the REST service: `./run.sh`

## Test the REST service directly

- View API listing: [http://localhost:3000/api-docs](http://localhost:3000/api-docs)
- View Swagger UI: [http://localhost:3000/swagger-ui/index.html](http://localhost:3000/swagger-ui/index.html)
- Get list of all countries: [http://localhost:3000/intl-postcode-api/countries/](http://localhost:3000/intl-postcode-api/countries/)
- Get list of cities (by default limited to 25): [http://localhost:3000/intl-postcode-api/cities/](http://localhost:3000/intl-postcode-api/cities/)
- View postcode lookup results: [http://localhost:3000/intl-postcode-api/cities/?country=GB&postcode=SW8](http://localhost:3000/intl-postcode-api/cities/?countryCode=GB&postcode=SW8)

![Swagger UI](https://github.com/leeprovoost/international-postcode-lookup-api/raw/master/screenshots/swagger.png)

## Use the experimental JQuery front-end

1. Host the HTML page on your local Apache server
2. Open [http://localhost/frontend-jquery/index.html](http://localhost/frontend-jquery/index.html) (add the right port number)
3. Start typing in a UK postcode or a UK city

![JQuery front-end](https://github.com/leeprovoost/international-postcode-lookup-api/raw/master/screenshots/front-end.png)

## TODO

See [issues page](https://github.com/leeprovoost/international-postcode-lookup-api/issues)
