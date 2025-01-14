@CoinDesk
Feature: To get the current price from Coin Desk

  Background:
  * def CoinDeskUrl = "https://api.coindesk.com/v1/bpi/currentprice.json"

  @CoinDesk
Scenario: User validate the response for the API
  Given url CoinDeskUrl
  When method get
  Then status 200
  And def Response = response.bpi
  And match Response == { USD: '#object', GBP: '#object', EUR: '#object' }

  And match Response.USD.code == 'USD'
  And match Response.GBP.code == 'GBP'
  And match Response.EUR.code == 'EUR'

  Then match Response.GBP.description == 'British Pound Sterling'