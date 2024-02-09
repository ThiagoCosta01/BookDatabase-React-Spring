ALTER TABLE `users`
MODIFY COLUMN account_non_expired bit(1) DEFAULT b'1',
MODIFY COLUMN account_non_locked bit(1) DEFAULT b'1',
MODIFY COLUMN credentials_non_expired bit(1) DEFAULT b'1',
MODIFY COLUMN enabled bit(1) DEFAULT b'1';