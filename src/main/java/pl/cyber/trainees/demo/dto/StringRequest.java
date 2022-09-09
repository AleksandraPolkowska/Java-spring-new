package pl.cyber.trainees.demo.dto;

import lombok.Getter;

import java.beans.ConstructorProperties;

@Getter

public class StringRequest {

    private final String stringPierwszy;
    private final String stringDrugi;
@ConstructorProperties({"stringPierwszy", "stringDrugi"})
// uzywane do odczytywania informacji ktora przychodzi jako obiekt jasonowy czyli body do zapytania
    public StringRequest(final String stringPierwszy, final String stringDrugi) {
        this.stringPierwszy = stringPierwszy;
        this.stringDrugi = stringDrugi;
    }



}
