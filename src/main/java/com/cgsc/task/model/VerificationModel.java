package com.cgsc.task.model;

import com.cgsc.task.entity.Verification;
import lombok.Data;

@Data
public class VerificationModel extends AbstractModel<Verification> {
    private boolean verified;
    private String reason;
    private String signature;
    private String payload;
}
