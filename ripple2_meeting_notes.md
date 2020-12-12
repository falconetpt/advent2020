# Ripple Meeting | 2020-12-20

## Auth
* Jack Recommends the use of 1 token in a distributed way
* There is a possibility to use **multiple** tokens tho
* Token needs to be refresh every hour, so we would need to trigger it sometime before in case anything changes

## Pagination
* Since the pagination is given by page + limit, there might 
be problem when querying the API and loosing records
    * one solution is using created_date asc to exhaust the list and not loose data between pagination

## Reconciliation
* Since ripple produces their own recon statements, does our service still need to publish info regarding payment state ? Or is it the responsibility of the payments' engine ?

## Testing Env
* Ripple has a kind of mock env so that we can use it, Jack will book a meeting with us latter, we can even use Thunes validations in this env
