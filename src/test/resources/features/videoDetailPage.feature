Feature: Youtube senaryosu

  Scenario: Halı saha videosu açması
    Given Youtube ana sayfası açılır
    When  Arama alanına "Özcan arpaci 100. yıl halı saha" değeri girilir
    And   Arama yapılır
    And   Arama yapılan videoya tıklanır
    Then  Videonun açıldığı kontrol edilir