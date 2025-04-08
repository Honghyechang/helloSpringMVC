package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.OfferDao;
import kr.ac.hansung.cse.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    //service ->dao 호출
    @Autowired
    private OfferDao offerDao;

    public void insertOffer(Offer offer) {
        offerDao.insert(offer);
    }
    public List<Offer> getAlloffers() {
        return offerDao.getOffers();
    }
}
