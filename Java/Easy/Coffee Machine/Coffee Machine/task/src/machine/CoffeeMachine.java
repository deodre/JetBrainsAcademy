package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Machine coffeeMachine = new Machine(550, 400, 540, 120, 9, State.STANDBY);
        coffeeMachine.displayMenu();
        do {
            coffeeMachine.processInput(scanner.next());
        } while (coffeeMachine.getState() != State.OFF);
    }
}

enum State {
    STANDBY,
    BUY,
    FILL,
    OFF
}

class Machine {

    private int availableMoney;
    private int availableWater;
    private int availableMilk;
    private int availableCoffeeBeans;
    private int availableDisposableCups;
    private State state;

    private int index = 0;

    public Machine(int availableMoney, int availableWater, int availableMilk, int availableCoffeeBeans, int availableDisposableCups, State state) {
        this.availableMoney = availableMoney;
        this.availableWater = availableWater;
        this.availableMilk = availableMilk;
        this.availableCoffeeBeans = availableCoffeeBeans;
        this.availableDisposableCups = availableDisposableCups;
        this.state = state;
    }

    public int getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(int availableMoney) {
        this.availableMoney = availableMoney;
    }

    public int getAvailableWater() {
        return availableWater;
    }

    public void setAvailableWater(int availableWater) {
        this.availableWater = availableWater;
    }

    public int getAvailableMilk() {
        return availableMilk;
    }

    public void setAvailableMilk(int availableMilk) {
        this.availableMilk = availableMilk;
    }

    public int getAvailableCoffeeBeans() {
        return availableCoffeeBeans;
    }

    public void setAvailableCoffeeBeans(int availableCoffeeBeans) {
        this.availableCoffeeBeans = availableCoffeeBeans;
    }

    public int getAvailableDisposableCups() {
        return availableDisposableCups;
    }

    public void setAvailableDisposableCups(int availableDisposableCups) {
        this.availableDisposableCups = availableDisposableCups;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void displayMenu() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    public void processInput(String input) {
        switch (state) {
            case STANDBY:
                switch (input) {
                    case "buy":
                        setState(State.BUY);
                        buyPrompt();
                        break;
                    case "fill":
                        setState(State.FILL);
                        fillPrompt(index);
                        break;
                    case "take":
                        takeMoney();
                        displayMenu();
                        break;
                    case "remaining":
                        showRemaining();
                        displayMenu();
                        break;
                    case "exit":
                        setState(State.OFF);
                        break;
                    default:
                        break;
                }
                break;
            case FILL:
                fill(index, input);
                index++;
                if (index > 3) {
                    setState(State.STANDBY);
                } else {
                    fillPrompt(index);
                }
                break;
            case BUY:
                buy(input);

                break;
        }
    }

    private void buy(String input) {
        switch (input) {
            case "back":
                setState(State.STANDBY);
                break;
            case "1":
                if (getAvailableWater() >= 250 && getAvailableCoffeeBeans() >= 16 && getAvailableDisposableCups() >= 1) {
                    setAvailableWater(getAvailableWater() -250);
                    setAvailableCoffeeBeans(getAvailableCoffeeBeans() -16);
                    setAvailableDisposableCups(getAvailableDisposableCups() - 1);
                    setAvailableMoney(getAvailableMoney() + 4);
                    System.out.println("I have enough resources, making you a coffee!");
                } else {
                    if (getAvailableWater() < 250) {
                        System.out.println("Sorry, not enough water!");
                    } else if (getAvailableCoffeeBeans() < 16) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else if (getAvailableDisposableCups() < 1) {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                }
                setState(State.STANDBY);
                break;
            case "2":
                if (getAvailableWater() >= 350 && getAvailableMilk() >= 75 && getAvailableCoffeeBeans() >= 20 && getAvailableDisposableCups() >= 1) {
                    setAvailableWater(getAvailableWater() - 350);
                    setAvailableMilk(getAvailableMilk() - 75);
                    setAvailableCoffeeBeans(getAvailableCoffeeBeans() - 20);
                    setAvailableDisposableCups(getAvailableDisposableCups() - 1);
                    setAvailableMoney(getAvailableMoney() + 7);
                    System.out.println("I have enough resources, making you a coffee!");
                } else {
                    if (getAvailableWater() < 350) {
                        System.out.println("Sorry, not enough water!");
                    } else if (getAvailableMilk() < 75) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (getAvailableCoffeeBeans() < 20) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else if (getAvailableDisposableCups() < 1) {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                }
                setState(State.STANDBY);
                break;
            case "3":
                if (getAvailableWater() >= 200 && getAvailableMilk() >= 100 && getAvailableCoffeeBeans() >= 12 && getAvailableDisposableCups() >= 1) {
                    setAvailableWater(getAvailableWater() - 200);
                    setAvailableMilk(getAvailableMilk() - 100);
                    setAvailableCoffeeBeans(getAvailableCoffeeBeans() - 12);
                    setAvailableDisposableCups(getAvailableDisposableCups() - 1);
                    setAvailableMoney(getAvailableMoney() + 6);
                    System.out.println("I have enough resources, making you a coffee!");
                } else {
                    if (getAvailableWater() < 200) {
                        System.out.println("Sorry, not enough water!");
                    } else if (getAvailableMilk() < 100) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (getAvailableCoffeeBeans() < 12) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else if (getAvailableDisposableCups() < 1) {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                }
                setState(State.STANDBY);
                break;
            default:
                setState(State.STANDBY);
                break;
        }

    }

    private void buyPrompt() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
    }

    private void fill(int indexFill, String input) {
        switch (indexFill) {
            case 0:
                setAvailableWater(getAvailableWater() + Integer.parseInt(input));
                break;
            case 1:
                setAvailableMilk(getAvailableMilk() + Integer.parseInt(input));
                break;
            case 2:
                setAvailableCoffeeBeans(getAvailableCoffeeBeans() + Integer.parseInt(input));
                break;
            case 3:
                setAvailableDisposableCups(getAvailableDisposableCups() + Integer.parseInt(input));
                break;
            default:
                break;
        }
    }

    private void fillPrompt(int indexFillPrompt) {
        switch (indexFillPrompt) {
            case 0:
                System.out.println("Write how many ml of water do you want to add:");
                break;
            case 1:
                System.out.println("Write how many ml of milk do you want to add:");
                break;
            case 2:
                System.out.println("Write how many grams of coffee beans do you want to add:");
                break;
            case 3:
                System.out.println("Write how many disposable cups do you want to add:");
                break;
            default:
                break;

        }
    }

    private void takeMoney() {
        System.out.println("I gave you $" + getAvailableMoney());
        setAvailableMoney(0);
    }

    private void showRemaining() {
        System.out.println("The coffee machine has:\n"
                + availableWater + " of water\n"
                + availableMilk + " of milk\n"
                + availableCoffeeBeans + " of coffee beans\n"
                + availableDisposableCups + " of disposable cups\n"
                + availableMoney + " of money");
    }
}
