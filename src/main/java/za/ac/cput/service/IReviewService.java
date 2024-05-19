package za.ac.cput.service;

import za.ac.cput.domain.Review;

import java.util.Set;

public interface IReviewService extends IService<Review, Long>{

    Set<Review> getall();

    Review create(Review review);

    Review read(Long id);

    Review update(Review review);

    void delete(Long id);
}
