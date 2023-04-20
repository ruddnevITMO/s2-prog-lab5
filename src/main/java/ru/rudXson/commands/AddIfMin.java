package ru.rudXson.commands;

import ru.rudXson.base.CLIController;
import ru.rudXson.base.InputManager;
import ru.rudXson.datatype.Flat;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class AddIfMin implements Command {
    CLIController c;

    public AddIfMin(CLIController c) {
        this.c = c;
    }

    @Override
    public String getDescription() {
        return "Add element if it is smaller than the smallest element of sorted array";
    }

    @Override
    public void execute(String[] args) {
        InputManager inManager = new InputManager(c.getScanner());
        Flat flat = new Flat();
        inManager.describeFlat(flat);


        Object[] flatsArray = c.getFlats().toArray();
        Flat minFlat = null;
        if (flatsArray.length > 0) {
            minFlat = (Flat) flatsArray[flatsArray.length - 1];
        } else {
            this.c.addFlat(flat);
            System.out.println("Flat was added to collection.");
        }

        if (minFlat == null || flat.compareTo(minFlat) < 0) {
            this.c.addFlat(flat);
            System.out.println("Flat was added to collection.");
        } else {
            System.out.println("Flat was not added to collection. Its value is greater than or equal to the minimum value in the collection.");
        }
    }
}