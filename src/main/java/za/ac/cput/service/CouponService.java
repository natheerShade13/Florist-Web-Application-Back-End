package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Coupon;
import za.ac.cput.repository.CouponRepository;

import java.util.List;

@Service
public class CouponService implements IService<Coupon, Long>{

    @Autowired
    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }


    @Override
    public Coupon create(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public Coupon read(Long aLong) {
        return couponRepository.findById(aLong).orElseThrow(()-> new IllegalStateException("Coupon with " +
                "Id " + aLong + " does not exist"));
    }

    @Override
    public Coupon update(Coupon coupon) {
        if (couponRepository.existsById(coupon.getCouponId())){
            return couponRepository.save(coupon);
        } else {
            throw new IllegalStateException("Coupon with Id " + coupon.getCouponId() + " does not exist");
        }
    }

    @Override
    public boolean delete(Long d) {
        if (couponRepository.existsById(d)){
            couponRepository.deleteById(d);
            return true;
        } else {
            throw new IllegalStateException("Coupon with Id " + d + " does not exist");
        }
    }

    @Override
    public List<Coupon> getAll() {
        return couponRepository.findAll();
    }
}
