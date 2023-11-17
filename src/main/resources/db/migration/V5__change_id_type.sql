ALTER TABLE quiz 
ALTER COLUMN "id" TYPE uuid USING id::uuid; 