package org.example.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DNI {
    private int number;
    private char letter;

    @Override
    public String toString()
    {
        return this.number + "-" + this.letter;
    }
}
