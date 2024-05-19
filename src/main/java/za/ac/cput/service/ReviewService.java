package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.ReviewRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReviewService implements IReviewService{
    private ReviewRepository repository;
    @Autowired
    ReviewService(ReviewRepository repository){this.repository = repository;}

    @Override
    public Set<Review> getall() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Review create(Review review) {
        return repository.save(review);
    }

    @Override
    public Review read(Long id) {
        return this.repository.findByReviewId(id);
        //.orElse(null)
    }

    @Override
    public Review update(Review review) {
        return repository.save(review);
    }

    @Override
    public void delete(Long id) {

    }
}
