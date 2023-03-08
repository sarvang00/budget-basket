import { UserAddress } from "./UserAddress";

export interface User {
    firstName: string;
    lastName: string;
    email: string;
    password: string;
    phoneNumber: string;
    createdAt: Date;
    updatedAt: Date;
    userAddress: UserAddress;
}