ALTER TABLE app_user.tasks
    ADD COLUMN user_id UUID;

ALTER TABLE app_user.tasks
    ADD CONSTRAINT fk_tasks_user
        FOREIGN KEY (user_id)
            REFERENCES app_user.details (user_id);

CREATE INDEX idx_tasks_user_id
    ON app_user.tasks (user_id);