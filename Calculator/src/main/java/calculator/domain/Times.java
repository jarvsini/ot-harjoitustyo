/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.domain;

/**
 *
 * @author jarvsini
 */
public class Times extends Operator {

    public Times() {
    }

    @Override
    Double run(Double num1, Double num2) {
        return num1 * num2;
    }

    
}
