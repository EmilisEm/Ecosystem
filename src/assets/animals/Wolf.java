package assets.animals;

public class Wolf extends Animal
{
    private final int attack;
    public Wolf(int health, int hunger, int reproductiveUrge, int visibility, int foodValue, int maxHealth, int maxHunger, int maxReproductiveUrge, int x, int y, int attack)
    {
        super(health, hunger, reproductiveUrge, visibility, foodValue, maxHealth, maxHunger, maxReproductiveUrge, x, y);

        this.attack = attack;
    }
    public Wolf()
    {
        this(150, 100, 0, 10, 50, 200, 150, 100, 0, 0, 25);
    }

    public int getAttack() {
        return this.attack;
    }
    public String toString()
    {
        return super.toString() + ", " + this.getAttack() + "ATC";
    }
    public void attack(Animal animal)
    {
        animal.setHealth(animal.getHealth() - this.attack);
        if (animal.getHealth() <= 0)
        {
            this.feed(animal);
        }
    }

    public Wolf reproduce(Animal mate)
    {
        super.reproduce(mate);
        return this.calculateInheritance(mate);
    }

    @Override
    public void processNeeds()
    {
        if (this.getActionCode() == 0)
        {
            if (this.getHunger() < this.getMaxHunger() / 3)
            {
                this.setActionCode(1);
            }
            else if (this.getReproductiveUrge() < this.getMaxReproductiveUrge() / 3)
            {
                this.setActionCode(2);
            }
            this.setActionCode(0);
        }
    }

    public final void feed(Animal entity)
    {
        this.setHealth(this.getHealth() + entity.getFoodValue());
        this.setHunger(this.getHunger() + entity.getFoodValue());

        if (this.getHunger() > this.getMaxHunger())
        {
            this.setHunger(this.getMaxHunger());
        }
        if (this.getHealth() > this.getMaxHealth())
        {
            this.setHealth(this.getMaxHealth());
        }
    }
    @Override
    public Wolf calculateInheritance(Animal animal) {
        if (!(animal instanceof Wolf))
        {
            return null;
        }
        Wolf mate = (Wolf)animal;
        return new Wolf(50, 50, 0, (this.getVisibilityRadius() + mate.getVisibilityRadius()) / 2 + this.randomNum(-1, 1), (this.getFoodValue() + mate.getFoodValue()) / 2 + this.randomNum(-5, 5), (this.getMaxHealth() + mate.getMaxHealth()) / 2 + this.randomNum(-5, 5), (this.getMaxHunger() + mate.getMaxHunger()) / 2 + this.randomNum(-5, 5), (this.getMaxReproductiveUrge() + mate.getMaxReproductiveUrge()) / 2 + this.randomNum(-5, 5), 0, 0, (this.getAttack() + mate.getAttack()) / 2 + this.randomNum(-5, 5));
    }
}

