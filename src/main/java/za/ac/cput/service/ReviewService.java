package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.ReviewRepository;

import java.util.List;

@Service
public class ReviewService implements IService<Review, Long>{

    @Autowired
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review read(Long aLong) {
        return reviewRepository.findById(aLong).orElseThrow(() -> new IllegalStateException("Review with Id " +
                aLong + " does not exist"));
    }

    @Override
    public Review update(Review review) {
        if (reviewRepository.existsById(review.getReviewId())){
            return reviewRepository.save(review);
        } else {
            throw new IllegalStateException("Review with Id " + review.getReviewId() + " does not exist");
        }
    }

    @Override
    public boolean delete(Long d) {
        if (reviewRepository.existsById(d)){
            reviewRepository.deleteById(d);
            return true;
        } else {
            throw new IllegalStateException("Review with Id " + d + " does not exist");
        }
    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }
}
