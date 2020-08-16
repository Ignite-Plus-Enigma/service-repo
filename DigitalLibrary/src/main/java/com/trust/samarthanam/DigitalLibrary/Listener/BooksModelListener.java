package com.trust.samarthanam.DigitalLibrary.Listener;

import com.trust.samarthanam.DigitalLibrary.Model.Books;
import com.trust.samarthanam.DigitalLibrary.Service.NextSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class BooksModelListener extends AbstractMongoEventListener<Books> {



        private NextSequenceService nextSequenceService;

        @Autowired
        public BooksModelListener(NextSequenceService nextSequenceService) {
            this.nextSequenceService = nextSequenceService;
        }
      @Override
    public void onBeforeConvert(BeforeConvertEvent<Books> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(nextSequenceService.getNextSequence(Books.SEQUENCE_NAME));
        }
    }
        }


