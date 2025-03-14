package battisti.anderson.alura_spring_lambdas_streams.model;

import java.util.List;

public class Review<T>
{
    private T item;
    private double review;
    private String description;

    public Review( T item, double review, String description )
    {
        this.item = item;
        this.review = review;
        this.description = description;
    }

    public double getReview()
    {
        return review;
    }

    public static <T> double getAverageReview( List<Review<T>> reviews )
    {
        if ( reviews.isEmpty() ) return 0;

        int total = 0;

        for ( Review<T> review : reviews )
        {
            total += review.getReview();
        }

        return (double) total / reviews.size();
    }
}
