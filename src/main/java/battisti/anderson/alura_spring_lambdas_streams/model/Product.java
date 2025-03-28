package battisti.anderson.alura_spring_lambdas_streams.model;

public class Product
{
    private String name;
    private double price;
    private String category;

    public Product( String name, double price, String category )
    {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public class Category
    {
        public static final String ELECTRONICS = "Electronics";
        public static final String FASHION     = "Fashion";
        public static final String HOME        = "Home";
        public static final String TOYS        = "Toys";
        public static final String GROCERY     = "Grocery";
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public String getCategory()
    {
        return category;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}
