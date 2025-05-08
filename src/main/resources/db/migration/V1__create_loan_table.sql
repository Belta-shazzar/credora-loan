CREATE TABLE loans
(
    id                  UUID                        NOT NULL,
    user_id             UUID                        NOT NULL,
    amount              DECIMAL(15, 2)              NOT NULL,
    currency            VARCHAR(255)                NOT NULL,
    duration            INTEGER                     NOT NULL,
    purpose             VARCHAR(255)                NOT NULL,
    payment_date        TIMESTAMP WITHOUT TIME ZONE,
    payed_on            TIMESTAMP WITHOUT TIME ZONE,
    status              VARCHAR(255)                NOT NULL,
    amount_paid         DECIMAL(15, 2),
    outstanding_balance DECIMAL(15, 2),
    created_at          TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at          TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_loans PRIMARY KEY (id)
);

CREATE INDEX idx_user_id ON loans (user_id);