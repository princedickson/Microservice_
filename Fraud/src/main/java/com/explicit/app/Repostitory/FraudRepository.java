package com.explicit.app.Repostitory;

import com.explicit.app.Model.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
