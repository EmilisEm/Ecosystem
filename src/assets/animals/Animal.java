package assets.animals;
import ecosystem.Ecosystem;

import java.util.Random;

public abstract class Animal implements Evolvable
{
    private static int entityCount = 0;
    private int health;
    private int hunger;
    private int reproductiveUrge;
    private int posX;
    private int posY;
    private final int visibilityRadius;
    private final int foodValue;
    private int actionCode;
    private final int maxHealth;
    private final int maxHunger;
    private final int maxReproductiveUrge;

    public Animal(int health, int hunger, int reproductiveUrge, int visibilityRadius, int foodValue, int maxHealth, int maxHunger, int maxReproductiveUrge, int x, int y)
    {
        this.health = health;
        this.hunger = hunger;
        this.reproductiveUrge = reproductiveUrge;
        this.posX = x;
        this.posY = y;
        this.visibilityRadius = visibilityRadius;
        this.foodValue = foodValue;
        this.maxHealth = maxHealth;
        this.maxReproductiveUrge = maxReproductiveUrge;
        this.maxHunger = maxHunger;
        this.actionCode = 0;

        entityCount++;
    }
    public Animal()
    {
        this(100, 100, 0, 10, 100, 100, 100, 100, 0, 0);
    }

    public final int getHealth()
    {
        return this.health;
    }

    public final void setHealth(int health)
    {
        this.health = health;
    }

    public final int getHunger()
    {
        return this.hunger;
    }

    public final void setHunger(int hunger)
    {
        this.hunger = hunger;
    }

    public final int getVisibilityRadius()
    {
        return this.visibilityRadius;
    }

    public final int getReproductiveUrge()
    {
        return this.reproductiveUrge;
    }
    public final int getActionCode()
    {
        return this.actionCode;
    }
    public final void setActionCode(int actionCode)
    {
        this.actionCode = actionCode;
    }

    public final void setReproductiveUrge(int reproductiveUrge)
    {
        this.reproductiveUrge = reproductiveUrge;
    }
    public final int getFoodValue()
    {
        return this.foodValue;
    }
    public final int getMaxHealth()
    {
        return this.maxHealth;
    }
    public final int getMaxHunger()
    {
        return this.maxHunger;
    }
    public final int getMaxReproductiveUrge()
    {
        return this.maxReproductiveUrge;
    }
    public String toString()
    {
        return this.getHealth() + "HP, " + this.getHunger() + "HNG, " + this.getReproductiveUrge() + "RU";
    }
    public final void move(int dx, int dy, Ecosystem ecosystem)
    {
        this.posX += dx;
        this.posY += dy;

        if (ecosystem.getX() < this.posX)
        {
            this.posX = ecosystem.getX();
        }
        else if (this.posX < 0)
        {
            this.posX = 0;
        }
        if (ecosystem.getY() < this.posY)
        {
            this.posY = ecosystem.getY();
        }
        else if (this.posY < 0)
        {
            this.posY = 0;
        }
    }
    public static int getEntityCount()
    {
        return entityCount;
    }
    public void feed()
    {
        this.hunger += 25;
        this.health += 25;
        this.setActionCode(0);

        if (this.hunger > this.maxHunger)
        {
            this.hunger = this.maxHunger;
        }
        if (this.health > this.maxHealth)
        {
            this.health = this.maxHealth;
        }
    }
    protected int randomNum(int min, int max)
    {

        return min + new Random().nextInt(max - min);
    }


    @Override
    public Animal reproduce(Animal mate)
    {
        this.reproductiveUrge = 0;
        this.actionCode = 0;
        mate.setReproductiveUrge(0);
        mate.setActionCode(0);

        return null;
    }
    @Override
    public abstract Animal calculateInheritance(Animal animal);
    public abstract void processNeeds();
}


