package assets.animals;

public class Rabbit extends Animal
{
    public Rabbit(int health, int hunger, int reproductiveUrge, int visibility, int foodValue, int maxHealth, int maxHunger, int maxReproductiveUrge, int x, int y)
    {
        super(health, hunger, reproductiveUrge, visibility,  foodValue, maxHealth, maxHunger, maxReproductiveUrge, x, y);
    }
    public Rabbit()
    {
        this(75, 100, 0, 10, 30, 75, 100, 100, 0, 0);
    }

    public Rabbit reproduce(Animal mate)
    {
        super.reproduce(mate);
        return this.calculateInheritance(mate);
    }

    @Override
    public void processNeeds()
    {
        if (this.getActionCode() == 0)
        {
            if (this.getHunger() < this.getMaxHunger() / 3 * 2)
            {
                this.setActionCode(1);
            }
            else if (this.getReproductiveUrge() < this.getMaxReproductiveUrge() / 3 * 2)
            {
                this.setActionCode(2);
            }
        }
    }
    @Override
    public Rabbit calculateInheritance(Animal animal) {
        return new Rabbit(50, 50, 0, (this.getVisibilityRadius() + animal.getVisibilityRadius()) / 2 + this.randomNum(-1, 1), (this.getFoodValue() + animal.getFoodValue()) / 2 + this.randomNum(-5, 5), (this.getMaxHealth() + animal.getMaxHealth()) / 2 + this.randomNum(-5, 5), (this.getMaxHunger() + animal.getMaxHunger()) / 2 + this.randomNum(-5, 5), (this.getMaxReproductiveUrge() + animal.getMaxReproductiveUrge()) / 2 + this.randomNum(-5, 5), 0, 0);
    }
}
