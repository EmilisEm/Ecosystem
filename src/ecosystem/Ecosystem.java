package ecosystem;

import assets.animals.*;


public class Ecosystem {
        private final int x;
        private final int y;
        private Animal[] entities;

        private MapNode[][] map;

    public Ecosystem(int width, int height)
    {
        this.x = width;
        this.y = height;

        this.entities = new Animal[width * height];
        this.map = new MapNode[width][height];

    }
    public Ecosystem()
    {
        this(100, 100);
    }
        public int getX()
        {
            return this.x;
        }
        public int getY()
        {
            return this.y;
        }

        public Animal[] getEntities()
        {
            return this.entities;
        }
        public MapNode[][] getMap()
        {
            return this.map;
        }

    public MapNode findNearestOpenNode(MapNode baseNode)
    {
        return null;
    }

    public void handleAnimal(Animal animal)
    {
        if (animal.getActionCode() == 1)
        {
            if (animal instanceof Rabbit)
            {
                animal.feed();
            }
            else
            {
                Wolf wolf = (Wolf) animal;
            }
        }
    }


        private class MapNode
        {
            private final int x;
            private final int y;
            private Boolean isEmpty;
            private Animal animal;

            public MapNode(int x, int y)
            {
                this.x = x;
                this.y = y;
            }

            public int getX()
            {
                return this.x;
            }
            public int getY()
            {
                return this.y;
            }

        }
}
