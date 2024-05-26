package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Review;
import za.ac.cput.service.ReviewService;

import java.util.Set;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
    public Review create(@RequestBody Review review){
        return reviewService.create(review);
    };

    @GetMapping("/review/{reviewId}")
    public Review read(@PathVariable long reviewId){
        return reviewService.read(reviewId);
    }

    @PostMapping("/update")
    public Review update(@RequestBody Review review){
        return reviewService.update(review);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        reviewService.delete(id);
    }

    @GetMapping("/getall")
    public Set<Review> getall(){
        return reviewService.getall();
    }
}
