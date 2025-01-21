using System.ComponentModel.DataAnnotations;

namespace AA_Backend.Models.DTO
{
    public class RegisterDTO
    {
        [Required]
        public string Username { get; set; } = null!;
        [EmailAddress]
        public string? Email { get; set; } = null!;
        [Required]
        public string Password { get; set; } = null!;
        [Required]
        public string PasswordConfirm { get; set; } = null!;
    }
}
